package example.searchapi.service.impl;

import example.searchapi.model.Role;
import example.searchapi.repository.RoleRepository;
import example.searchapi.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;

    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Role getRoleByName(String name) {
        return repository.getRoleByName(name);
    }

    @Override
    public Role save(Role role) {
        return repository.save(role);
    }
}
