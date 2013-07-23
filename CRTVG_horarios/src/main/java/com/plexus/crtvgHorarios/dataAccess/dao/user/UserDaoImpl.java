package com.plexus.crtvgHorarios.dataAccess.dao.user;



import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.plexus.crtvgHorarios.dataAccess.dao.common.BaseDao;
import com.plexus.crtvgHorarios.dataAccess.pojo.UserPojo;

@Repository
public class UserDaoImpl extends BaseDao implements UserDao {

    private static final Logger LOG = Logger.getLogger(UserDaoImpl.class.getName());
    
    private static final String SQL_SELECT_BY_ID = " SELECT * FROM users WHERE user_id = ? ";
    private static final String SQL_SELECT_BY_USERNAME = " SELECT * FROM users WHERE username = ? ";

    public UserPojo getById(long userId) {
        UserPojo user = null;
        
        Object[] parameters = {userId};
        
        user = super.jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, parameters, new UserRowMapper());

        return user;
    }
    
    

	@Override
	public UserPojo getUser(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserPojo getUserByUsername(String username) throws UsernameNotFoundException {
        UserPojo user = null;
        
        Object[] parameters = {username};
        
        try {
        	user = super.jdbcTemplate.queryForObject(SQL_SELECT_BY_USERNAME, parameters, new UserRowMapper());
        }
        catch (Exception e) {
        	e.printStackTrace();        	
        }

        return user;
	}

	@Override
	public UserPojo insertUser(UserPojo user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(UserPojo user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserById(Long userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserPojo> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

    
	
}
