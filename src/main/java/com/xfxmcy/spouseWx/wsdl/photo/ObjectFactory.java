
package com.xfxmcy.spouseWx.wsdl.photo;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.xfxmcy.spouseWx.wsdl.photo package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.xfxmcy.spouseWx.wsdl.photo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SmPhotoArray }
     * 
     */
    public SmPhotoArray createSmPhotoArray() {
        return new SmPhotoArray();
    }

    /**
     * Create an instance of {@link QueryParam }
     * 
     */
    public QueryParam createQueryParam() {
        return new QueryParam();
    }

    /**
     * Create an instance of {@link SmPhoto }
     * 
     */
    public SmPhoto createSmPhoto() {
        return new SmPhoto();
    }

}
