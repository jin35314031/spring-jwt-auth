package com.rdbf.demo.apiauth.service;

import com.rdbf.demo.apiauth.controller.SampleController;
import com.rdbf.demo.apiauth.domain.People;
import com.rdbf.demo.apiauth.repository.PeopleRepository;
import org.apache.ibatis.annotations.AutomapConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final PeopleRepository peopleRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public UserDetailsServiceImpl(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        People people = peopleRepository.findByLoginId(username);

        if(people == null){
            LOGGER.info("ユーザーが見つかりませんでした");
            throw new UsernameNotFoundException("User Not Found with -> username or email: " + username);
        }

        LOGGER.info("ログイン成功:::::username::::"+username+"::::::LoginID::::"+people.getLoginId());

        return User.withUsername(username)
                .password(people.getPassword())
                .authorities("ROLE_USER") // ユーザの権限
                .build();
    }

}
