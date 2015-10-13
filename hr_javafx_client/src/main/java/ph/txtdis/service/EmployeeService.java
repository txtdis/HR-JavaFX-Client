package ph.txtdis.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import ph.txtdis.dto.Employee;

@Service
public class EmployeeService extends AbstractSpunService<Employee, Long> {

    public Employee find(Long id) throws ResourceAccessException {
        return getOne("/" + id);
    }

    public List<Employee> search(String name) throws ResourceAccessException {
        return getList("/search?name=" + name);
    }
}
