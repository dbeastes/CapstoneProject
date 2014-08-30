/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author dustineastes
 */
public class HibernateUtil {

private static SessionFactory sessionFactory;
private static ServiceRegistry serviceRegistry;

public static SessionFactory getSessionFactory() {
    Configuration configuration = new Configuration();
    configuration.configure();
    serviceRegistry = (ServiceRegistry) new ServiceRegistryBuilder().applySettings(
            configuration.getProperties()).buildServiceRegistry();
    sessionFactory = configuration.buildSessionFactory((org.hibernate.service.ServiceRegistry) serviceRegistry);
    return sessionFactory;
}
}
