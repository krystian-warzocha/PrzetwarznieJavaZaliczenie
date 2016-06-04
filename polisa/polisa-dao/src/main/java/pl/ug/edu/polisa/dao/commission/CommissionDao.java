package pl.ug.edu.polisa.dao.commission;

import java.sql.SQLException;
import java.util.List;

import pl.ug.edu.polisa.dao.core.BaseCRUDDao;
import pl.ug.edu.polisa.domain.commission.CommissionEntity;
import pl.ug.edu.polisa.domain.commission.CommissionFilter;

public class CommissionDao extends BaseCRUDDao<CommissionEntity, CommissionFilter> {

	@Override
	public void create(CommissionEntity object) throws SQLException {
		
		
	}

	@Override
	public CommissionEntity retrieve(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(CommissionEntity object) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CommissionEntity> select(CommissionFilter filter) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
