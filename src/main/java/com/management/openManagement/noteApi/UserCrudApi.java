package com.management.openManagement.noteApi;

import com.management.openManagement.dto.UserDto;
import com.management.openManagement.exception.ResourceNotFoundException;
import com.management.openManagement.mapper.UserMapper;
import com.management.openManagement.models.User;
import com.management.openManagement.services.IUserService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@EnableAutoConfiguration
@ComponentScan
@RestController
@RequestMapping("/user")
@Api(value="User Management System", description="Operations pertaining to user in User Management System")
public class UserCrudApi {

    private Logger logger = LoggerFactory.getLogger(UserCrudApi.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired  //Why not recommended ?
    IUserService userService;

    @ApiOperation(value = "View a list of available users", response = List.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        logger.info("DEBUG MODE IS ON");
        return ResponseEntity.ok(userMapper.toUserDTOs(userService.findAll()));
    }

    @ApiOperation(value = "Get an user by Id")
    @GetMapping(value = "/{id}",produces = "application/json")
    public ResponseEntity<UserDto> findById(@ApiParam(value = "User id from which user object will retrieve", required = true)
            @PathVariable Long id) throws ResourceNotFoundException {
        Optional<User> user = Optional.ofNullable(userService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :" + id)));
        return ResponseEntity.ok(userMapper.toUserDto(user.get()));
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.save(userMapper.toUser(userDto)));
    }

    @PutMapping
    public ResponseEntity<User> update(@Valid @RequestBody UserDto userDto) throws ResourceNotFoundException {
      Optional.ofNullable(userService.findById(userDto.getId())
        .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :" + userDto.getId())));
        return ResponseEntity.ok(userService.save(userMapper.toUser(userDto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!userService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }

        userService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
