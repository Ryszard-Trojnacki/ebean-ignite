
package org.avaje.ebean.ignite.config;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.avaje.ebean.l2ignite.config package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.avaje.ebean.l2ignite.config
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link L2Configuration }
     * 
     */
    public L2Configuration createL2Configuration() {
        return new L2Configuration();
    }

    /**
     * Create an instance of {@link L2CacheConfig }
     * 
     */
    public L2CacheConfig createL2CacheConfig() {
        return new L2CacheConfig();
    }

    /**
     * Create an instance of {@link L2Apply }
     * 
     */
    public L2Apply createL2Apply() {
        return new L2Apply();
    }

    /**
     * Create an instance of {@link L2CacheMatch }
     * 
     */
    public L2CacheMatch createL2CacheMatch() {
        return new L2CacheMatch();
    }

}