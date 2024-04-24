package mybank.project.loansdao.Security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MyBankOfficialsService implements UserDetailsService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    Logger logger= LoggerFactory.getLogger(MyBankOfficialsService.class);


    public MyBankOfficials signingUp(MyBankOfficials myBankOfficials){
        int ack = jdbcTemplate.update("insert into MYBANK_APP_CUSTOMER   values(CUSTOMERID_SEQ.nextval,?,?,?,?,?,?,?)",new Object[]{
                myBankOfficials.getCustomerName(),myBankOfficials.getCustomerAddress(),myBankOfficials.getCustomerStatus(),
                myBankOfficials.getCustomerContact(),myBankOfficials.getUsername(),myBankOfficials.getPassword(),myBankOfficials.getAttempts()
        });
        return myBankOfficials;
    }

    public MyBankOfficials findByUsername(String username){
        List<MyBankOfficials> myBankOfficialsList = jdbcTemplate.query("select * from MYBANK_APP_CUSTOMER",new BeanPropertyRowMapper<>(MyBankOfficials.class));
        //new Object[]{username},new BeanPropertyRowMapper<>(MyBankOfficials.class));
                MyBankOfficials myBankOfficials=filterByUserName(myBankOfficialsList, username);
        return myBankOfficials;
    }
    public MyBankOfficials filterByUserName(List<MyBankOfficials> myBankOfficialsList,String username){
        // stream Filter
        List<MyBankOfficials> filteredMyBankOfficials = myBankOfficialsList.stream()
                .filter(myBankOfficials -> myBankOfficials.getUsername().equals(username))
                .collect(Collectors.toList());
        if (!filteredMyBankOfficials.isEmpty()) {
            return filteredMyBankOfficials.get(0);
        } else {
            return null;
        }
    }
    public void updateAttempts(MyBankOfficials myBankOfficials){
        jdbcTemplate.update("update MYBANK_APP_CUSTOMER set attempts=? where username=?",
                new Object[]{myBankOfficials.getAttempts(),myBankOfficials.getUsername()});
        logger.info("Attempts are updated");
    }

    public void updateStatus(MyBankOfficials myBankOfficials){
        jdbcTemplate.update("update MYBANK_APP_CUSTOMER set CUSTOMER_STATUS='Inactive' where username=?",
                new Object[]{myBankOfficials.getUsername()});
        logger.info("Status has changed");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyBankOfficials officials = findByUsername(username);
        if(officials==null)
            throw new UsernameNotFoundException(username);
        return officials;
    }
}
