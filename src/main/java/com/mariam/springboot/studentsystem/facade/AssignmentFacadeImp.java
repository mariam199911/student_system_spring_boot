package com.mariam.springboot.studentsystem.facade;

import com.mariam.springboot.studentsystem.dto.AssignmentDTO;
import com.mariam.springboot.studentsystem.entity.Assignment;
import com.mariam.springboot.studentsystem.entity.Course;
import com.mariam.springboot.studentsystem.exception.NotFoundException;
import com.mariam.springboot.studentsystem.service.AssignmentService;
import com.mariam.springboot.studentsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class AssignmentFacadeImp implements  AssignmentFacade{
    private AssignmentService assignmentService;
    private CourseService courseService;

    @Autowired
    public AssignmentFacadeImp(AssignmentService assignmentService, CourseService courseService) {
        this.assignmentService = assignmentService;
        this.courseService = courseService;
    }


    @Override
    public void save(AssignmentDTO assignmentDTO) {
        Assignment assignment = convertToEntity(assignmentDTO);
        assignmentService.save(assignment);
        assignmentDTO.setId(assignment.getId());
    }

    @Override
    public void deleteById(int id) {
        Assignment assignment = assignmentService.findById(id);

        if(assignment == null) {

            throw new NotFoundException("Assignment id not found - " + id);
//            throw new RuntimeException("Assignment id not found - " + id);
        }

        assignmentService.deleteById(id);
    }



    @Override
    public List<AssignmentDTO> findAll() {
        List<Assignment> assignments =  assignmentService.findAll();
        List<AssignmentDTO> assignmentDTOList =new ArrayList<>();
        for (Assignment assignment:
                assignments) {
            assignmentDTOList.add(convertToDto(assignment));

        }
        return  assignmentDTOList;
    }

    @Override
    public AssignmentDTO findById(int id) {
        Assignment assignment = assignmentService.findById(id);

        if(assignment == null) {
            throw new NotFoundException("Assignment id not found - " + id);
//            throw new RuntimeException("Assignment id not found - " + id);
        }

        return convertToDto(assignment);
    }
///////////////////////////////////////////////////////////////////////////////
    @Override
    public List<AssignmentDTO> getAssignmentsInCourse(int courseId) {
        List<Assignment> assignmentList = assignmentService.viewAssignments(courseId);
        List<AssignmentDTO> assignmentDTOList = new ArrayList<>();

        for (Assignment assignment:
                assignmentList) {
            assignmentDTOList.add(convertToDto(assignment));

        }
        return  assignmentDTOList;
    }
/////////////////////////////////////////////////////////////////////////////////
    private AssignmentDTO convertToDto(Assignment assignment) {
        return new AssignmentDTO(assignment);
    }

    private Assignment convertToEntity(AssignmentDTO assignmentDTO) {

        Course course = courseService.findById(assignmentDTO.getCourseId());

        if(course == null) {
            throw new RuntimeException("Course id not found - " + assignmentDTO.getCourseId());
        }

        Assignment assignment = new Assignment(assignmentDTO);
        assignment.setCourse(course);

        return assignment;
    }
}
