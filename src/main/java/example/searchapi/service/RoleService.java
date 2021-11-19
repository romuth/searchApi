package example.searchapi.service;

import example.searchapi.model.Role;

public interface RoleService {
    Role getRoleByName(String name);

    Role save(Role role);
}
