package app.service.role;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dao.role.RoleDao;
import app.model.Role;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class RoleServiceImpl implements RoleService{

	private RoleDao roleDao;
	
	@Override
	public Role getRoleByRole(String role) {
		List<Role> roles = roleDao.findByRole(role);
		return roles.stream().filter(e -> e.getRole().equals(role.toLowerCase())).findFirst().orElse(null);
	}

}
