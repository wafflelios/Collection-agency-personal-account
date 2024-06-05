package ru.project.collection_agency.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.project.collection_agency.entities.*;
import ru.project.collection_agency.repositories.UserRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class UserService implements UserDetailsService
{
    protected final UserRepository repository;

    @Autowired
    public UserService(UserRepository userRepository)
    {
        repository = userRepository;
    }

    public List<User> getAllUsers()
    {
        List<User> result = new ArrayList<>();
        repository.findAll().forEach(result::add);
        return result.stream().toList();
    }

    public User getUserByUsername(String username)
    {
        return repository.findByUsername(username);
    }

    public User getUserById(Long id)
    {
        return repository.findById(id).get();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User myUser = repository.findByUsername(username);
        return new org.springframework.security.core.userdetails.User(myUser.getUsername(), myUser.getPassword(),
                mapRolesToAthorities(myUser.getRoles()));
    }


    private List<? extends GrantedAuthority> mapRolesToAthorities(Set<Role> roles)
    {
        return roles.stream().map(r -> new SimpleGrantedAuthority("ROLE_" + r.name())).collect(Collectors.toList());
    }


    public void addUser(User user) throws Exception
    {
        User userFromDb = repository.findByUsername(user.getUsername());
        if (userFromDb != null)
        {
            throw new Exception("user exist");
        }
        user.setRoles(Collections.singleton(Role.USER));
        user.setActive(true);
        repository.save(user);
    }

    public void updateUser(User user)
    {
        repository.save(user);
    }

    public Date StringToDate(String strDate)
    {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date result = new Date();
        try
        {
            result = sf.parse(strDate);
        }
        catch (ParseException exception)
        {
            exception.printStackTrace();
        }
        return result;
    }

    public User getUserByEmail(String email)
    {
        return repository.findByEmail(email);
    }

}
