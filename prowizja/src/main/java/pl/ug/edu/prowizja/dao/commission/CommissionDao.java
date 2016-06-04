package pl.ug.edu.prowizja.dao.commission;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pl.ug.edu.prowizja.dao.core.BaseCRUDDao;
import pl.ug.edu.prowizja.dao.core.ConnectionFactory;
import pl.ug.edu.prowizja.domain.commission.CommissionEntity;
import pl.ug.edu.prowizja.domain.commission.CommissionFilter;
import pl.ug.edu.prowizja.domain.commission.Wojewodztwo;

public class CommissionDao extends BaseCRUDDao<CommissionEntity, CommissionFilter> {

	private Log log = LogFactory.getLog(CommissionDao.class);

	@Override
	public void create(CommissionEntity commission) throws SQLException {
		validateObject(commission);
		String tableName = getTableNameAndValidate(commission);
		PreparedStatement ps = ConnectionFactory.instance().getConnection()
				.prepareStatement("INSERT INTO " + tableName + "(polisa_id, wojewodztwo, wartosc) VALUES(?,?,?)");
		ps.setInt(1, commission.getPolisaId());
		ps.setString(2, commission.getWojewodztwo().name());
		ps.setBigDecimal(3, commission.getWartosc());
		int row = ps.executeUpdate();

		if (row == 0) {
			throw new SQLException("Dodawanie prowizji sie nie udalo!");
		}

		ResultSet generatedKeys = ps.getGeneratedKeys();
		if (generatedKeys.next()) {
			commission.setId(generatedKeys.getInt(1));
		} else {
			throw new SQLException("Dodanie prowizji sie nie udalo. Brak ID.");
		}

		log.info("Dodano " + row + " rekordów do tabeli " + tableName);
	}

	@Override
	public CommissionEntity retrieve(Integer id) throws SQLException {
		CommissionEntity result = null;
		String query = "SELECT * FROM PROWIZJA WHERE ID = ?";
		PreparedStatement ps = ConnectionFactory.instance().getConnection().prepareStatement(query);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			result = new CommissionEntity();
			result.setId(rs.getInt("id"));
			result.setPolisaId(rs.getInt("polisa_id"));
			result.setWojewodztwo(Wojewodztwo.byCode(rs.getString("wojewodztwo")));
			result.setWartosc(rs.getBigDecimal("wartosc"));
		}
		return result;
	}

	@Override
	public void update(CommissionEntity commission) throws SQLException {
		validateObject(commission);
		String tableName = getTableNameAndValidate(commission);
		PreparedStatement ps = ConnectionFactory.instance().getConnection().prepareStatement(
				"UPDATE " + tableName + " set polisa_id = ?, wojewodztwo = ?, wartosc = ? WHERE id = ?");
		ps.setInt(1, commission.getPolisaId());
		ps.setString(2, commission.getWojewodztwo().getCode());
		ps.setBigDecimal(3, commission.getWartosc());
		int row = ps.executeUpdate();
		log.info("Zaktualizowano " + row + " rekordów do tabeli " + tableName);
	}

	@Override
	public List<CommissionEntity> select(CommissionFilter filter) throws SQLException {
		List<CommissionEntity> result = new ArrayList<CommissionEntity>();
		if (filter == null) {
			return result;
		}
		StringBuilder sb = new StringBuilder("SELECT * FROM PROWIZJA WHERE 1=1");
		if (filter.getPolicyId() != null) {
			sb.append(" and polisa_id = ?");
		}
		if (filter.getWojewodztwo() != null) {
			sb.append(" and wojewodztwo = ?");
		}
		PreparedStatement ps = ConnectionFactory.instance().getConnection().prepareStatement(sb.toString());
		int whereCounter = 1;
		if (filter.getPolicyId() != null) {
			ps.setInt(whereCounter++, filter.getPolicyId());
		}
		if (filter.getWojewodztwo() != null) {
			ps.setString(whereCounter++, filter.getWojewodztwo().getCode());
		}

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			CommissionEntity commission = new CommissionEntity();
			commission.setId(rs.getInt("id"));
			commission.setPolisaId(rs.getInt("polisa_id"));
			commission.setWojewodztwo(Wojewodztwo.byCode(rs.getString("wojewodztwo")));
			commission.setWartosc(rs.getBigDecimal("wartosc"));
			result.add(commission);
		}
		return result;
	}

}
