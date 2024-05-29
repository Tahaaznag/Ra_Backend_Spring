package com.bergerlevrault.Remoteassist.rest.controller;

import com.bergerlevrault.Remoteassist.Dto.UserRaDto;
import com.bergerlevrault.Remoteassist.Service.Imp.UserRaServiceImp;
import com.bergerlevrault.Remoteassist.utils.ResourcesPath;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ResourcesPath.CLIENT)
@Api(value = "User Management System", description = "Operations pertaining to users in Remote Assist")
public class UserController {

    private final UserRaServiceImp userRaService;

    public UserController(UserRaServiceImp userRaService) {
        this.userRaService = userRaService;
    }

    @ApiOperation(value = "Create a new user")
    @PostMapping(ResourcesPath.USERS)
    public ResponseEntity<UserRaDto> createUser(@RequestBody UserRaDto userDto) {
        UserRaDto addedUser = userRaService.createUser(userDto);
        return new ResponseEntity<>(addedUser, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get all users")
    @GetMapping(ResourcesPath.ALLUSERS)
    public ResponseEntity<List<UserRaDto>> getAllUsers() {
        List<UserRaDto> users = userRaService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @ApiOperation(value = "Get user by ID")
    @GetMapping(ResourcesPath.USERS + "/{" + ResourcesPath.USERSID + "}")
    public ResponseEntity<UserRaDto> getUserById(@ApiParam(value = "User ID", required = true) @PathVariable Long id) {
        Optional<UserRaDto> user = userRaService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @ApiOperation(value = "Update user")
    @PutMapping("update/{id}")
    public ResponseEntity<UserRaDto> updateUser(@ApiParam(value = "User ID", required = true) @PathVariable Long id, @RequestBody UserRaDto userDto) {
        try {
            UserRaDto updatedUser = userRaService.updateUser(id, userDto);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Delete user")
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteUser(@ApiParam(value = "User ID", required = true) @PathVariable Long id) {
        userRaService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}