package org.example;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Destination;
import javax.jms.Session;
import java.sql.Connection;
import java.util.Comparator;

public class provider {
    public static void main(String[] args) {
        ActiveMQConnectionFactory activeMQConnectionFactory=new ActiveMQConnectionFactory();
        Connection connection=activeMQConnectionFactory.createConnection();
        Session session=Connection.createSession();
        Destination destination=
    }
}
