package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import Connection.ConnectionFactory;
import dto.Address;
import dto.EMail;
import dto.Person;

/**
 * Created by DDEZOYSA on 8/26/2016.
 */

public class PersonDAO {

    public Person getPersonByPartyId(int party_id){
        Person person = null;
        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM person as p LEFT JOIN Address as a on p.party_id=a.party_id LEFT JOIN emails as e ON p.party_id=e.party_id where p.party_id=" + party_id + ";");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                person = new Person();
                person.setParty_id(resultSet.getInt("party_id"));
                person.setParty_type(resultSet.getString("party_type"));
                person.setSsn(resultSet.getString("ssn"));
                person.setSex(resultSet.getString("sex"));
                person.setFORENAMES(resultSet.getString("FORENAMES"));
                person.setMIDDLENAME(resultSet.getString("MIDDLENAME"));
                person.setLASTNAME(resultSet.getString("LASTNAME"));
                person.setPREFERRED(resultSet.getString("PREFERRED"));
                person.setTITLE(resultSet.getString("TITLE"));
                person.setDOB(resultSet.getDate("DOB"));
                person.setMARITAL_STATUS(resultSet.getString("MARITAL_STATUS"));
                person.setTAX_REF_NO(resultSet.getString("TAX_REF_NO"));
                person.setDECEASED(resultSet.getString("DECEASED"));
                person.setDATE_OF_DEATH(resultSet.getString("DATE_OF_DEATH"));
                person.setEMPLOYMENT_STATUS(resultSet.getString("EMPLOYMENT_STATUS"));
                person.setCOUPLE_ID(resultSet.getInt("COUPLE_ID"));
                person.setActive(resultSet.getString("active"));
                person.setAlter_date(resultSet.getDate("alter_date"));

                Address address = new Address();
                address.setParty_id(resultSet.getInt("party_id"));
                address.setADDRESSLINE1(resultSet.getString("ADDRESSLINE1"));
                address.setADDRESSLINE2(resultSet.getString("ADDRESSLINE2"));
                address.setADDRESSLINE3(resultSet.getString("ADDRESSLINE3"));
                address.setADDRESS_LINE4(resultSet.getString("ADDRESS_LINE4"));
                address.setADDRESS_LINE5(resultSet.getString("ADDRESS_LINE5"));
                address.setADDRESS_LINE6(resultSet.getString("ADDRESS_LINE6"));
                address.setPostcode(resultSet.getInt("postcode"));
                address.setGONEAWAY(resultSet.getString("GONEAWAY"));
                address.setPC_DAY(resultSet.getString("PC_DAY"));
                address.setPC_TIME(resultSet.getString("PC_TIME"));

                person.setAddress(address);

                person.setLandPhoneNumbers(new PhoneNumberDAO().getPhoneNumberByPartyIdType(party_id, "l"));
                person.setMobilePhoneNumbers(new PhoneNumberDAO().getPhoneNumberByPartyIdType(party_id,"h"));

                EMail eMail = new EMail();
                eMail.setParty_id(resultSet.getInt("party_id"));
                eMail.setEmail_type(resultSet.getString("email_type"));
                eMail.setEmail_id(resultSet.getString("email_id"));
                eMail.setActive(resultSet.getString("active"));

                person.seteMail(eMail);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return person;
    }

    public Person getPersonByEMailId(String email_id){
        Person person = null;
        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM person as p LEFT JOIN emails as e ON p.party_id=e.party_id LEFT JOIN Address as a ON p.party_id=a.party_id where e.email_id='" + email_id + "';");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                person = new Person();
                person.setParty_id(resultSet.getInt("party_id"));
                person.setParty_type(resultSet.getString("party_type"));
                person.setSsn(resultSet.getString("ssn"));
                person.setSex(resultSet.getString("sex"));
                person.setFORENAMES(resultSet.getString("FORENAMES"));
                person.setMIDDLENAME(resultSet.getString("MIDDLENAME"));
                person.setLASTNAME(resultSet.getString("LASTNAME"));
                person.setPREFERRED(resultSet.getString("PREFERRED"));
                person.setTITLE(resultSet.getString("TITLE"));
                person.setDOB(resultSet.getDate("DOB"));
                person.setMARITAL_STATUS(resultSet.getString("MARITAL_STATUS"));
                person.setTAX_REF_NO(resultSet.getString("TAX_REF_NO"));
                person.setDECEASED(resultSet.getString("DECEASED"));
                person.setDATE_OF_DEATH(resultSet.getString("DATE_OF_DEATH"));
                person.setEMPLOYMENT_STATUS(resultSet.getString("EMPLOYMENT_STATUS"));
                person.setCOUPLE_ID(resultSet.getInt("COUPLE_ID"));
                person.setActive(resultSet.getString("active"));
                person.setAlter_date(resultSet.getDate("alter_date"));

                Address address = new Address();
                address.setParty_id(resultSet.getInt("party_id"));
                address.setADDRESSLINE1(resultSet.getString("ADDRESSLINE1"));
                address.setADDRESSLINE2(resultSet.getString("ADDRESSLINE2"));
                address.setADDRESSLINE3(resultSet.getString("ADDRESSLINE3"));
                address.setADDRESS_LINE4(resultSet.getString("ADDRESS_LINE4"));
                address.setADDRESS_LINE5(resultSet.getString("ADDRESS_LINE5"));
                address.setADDRESS_LINE6(resultSet.getString("ADDRESS_LINE6"));
                address.setPostcode(resultSet.getInt("postcode"));
                address.setGONEAWAY(resultSet.getString("GONEAWAY"));
                address.setPC_DAY(resultSet.getString("PC_DAY"));
                address.setPC_TIME(resultSet.getString("PC_TIME"));

                person.setAddress(address);

                person.setLandPhoneNumbers(new PhoneNumberDAO().getPhoneNumberByPartyIdType(person.getParty_id(), "l"));
                person.setMobilePhoneNumbers(new PhoneNumberDAO().getPhoneNumberByPartyIdType(person.getParty_id(),"h"));

                EMail eMail = new EMail();
                eMail.setParty_id(resultSet.getInt("party_id"));
                eMail.setEmail_type(resultSet.getString("email_type"));
                eMail.setEmail_id(resultSet.getString("email_id"));
                eMail.setActive(resultSet.getString("active"));

                person.seteMail(eMail);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return person;
    }
}
