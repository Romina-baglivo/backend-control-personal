package  com.example.controlDePersonal.services.impl;

import com.example.controlDePersonal.exceptions.EmployeeNotFoundException;
import com.example.controlDePersonal.model.dtos.EmployeeDTO;
import com.example.controlDePersonal.model.entities.EmployeeEntity;
import com.example.controlDePersonal.model.mappers.EmployeeMapper;
import com.example.controlDePersonal.repositories.CheckInRepository;
import com.example.controlDePersonal.repositories.CheckOutRepository;
import com.example.controlDePersonal.repositories.EmployeeRepository;
import com.example.controlDePersonal.services.interfaces.EmployeeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final CheckOutRepository checkOutRepository;
    private final CheckInRepository checkInRepository;


    @Override
    public EmployeeDTO create(EmployeeDTO employeeDTO) {
        EmployeeEntity entity = employeeMapper.toEntity(employeeDTO);
        EmployeeEntity saved = employeeRepository.save(entity);
        return employeeMapper.toDTO(saved);
    }

    @Override
    public void update(String dni, EmployeeDTO employeeDTO) {
        EmployeeEntity entity = employeeRepository.findById(dni)
                .orElseThrow(() -> new EmployeeNotFoundException(dni));

        employeeMapper.updateEntity(employeeDTO, entity);
        employeeRepository.save(entity);

    }

    @Override
    @Transactional
    public void delete(String dni) {
        // Primero borra check-ins y check-outs
        checkInRepository.deleteAllByEmployeeDni(dni);
        checkOutRepository.deleteAllByEmployeeDni(dni);

        // Luego borra el empleado
        if (!employeeRepository.existsById(dni)) {
            throw new EmployeeNotFoundException(dni);
        }
        employeeRepository.deleteById(dni);
    }

    @Override
    public EmployeeDTO findBy(String dni) {
        EmployeeEntity entity = employeeRepository.findById(dni)
                .orElseThrow(() -> new EmployeeNotFoundException(dni));
        return employeeMapper.toDTO(entity);
    }

    @Override
    public List<EmployeeDTO> findAll() {
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::toDTO)
                .toList();
    }



}
