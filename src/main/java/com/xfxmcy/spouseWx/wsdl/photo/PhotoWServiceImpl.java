
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.xfxmcy.spouseWx.wsdl.photo;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.6
 * 2015-06-16T09:03:07.321+08:00
 * Generated source version: 2.7.6
 * 
 */

@javax.jws.WebService(
                      serviceName = "PhotoWServiceService",
                      portName = "PhotoWServicePort",
                      targetNamespace = "http://webservice.spouse.xfxmcy.com/",
                      wsdlLocation = "http://xfxmcy.com/cyws/photoWs?wsdl",
                      endpointInterface = "com.xfxmcy.spouseWx.wsdl.photo.PhotoWService")
                      
public class PhotoWServiceImpl implements PhotoWService {

    private static final Logger LOG = Logger.getLogger(PhotoWServiceImpl.class.getName());

    /* (non-Javadoc)
     * @see com.xfxmcy.spouseWx.wsdl.photo.PhotoWService#queryHisPhotos(com.xfxmcy.spouseWx.wsdl.photo.QueryParam  arg0 )*
     */
    public com.xfxmcy.spouseWx.wsdl.photo.SmPhotoArray queryHisPhotos(QueryParam arg0) { 
        LOG.info("Executing operation queryHisPhotos");
        System.out.println(arg0);
        try {
            com.xfxmcy.spouseWx.wsdl.photo.SmPhotoArray _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.xfxmcy.spouseWx.wsdl.photo.PhotoWService#queryMyPhotos(com.xfxmcy.spouseWx.wsdl.photo.QueryParam  arg0 )*
     */
    public com.xfxmcy.spouseWx.wsdl.photo.SmPhotoArray queryMyPhotos(QueryParam arg0) { 
        LOG.info("Executing operation queryMyPhotos");
        System.out.println(arg0);
        try {
            com.xfxmcy.spouseWx.wsdl.photo.SmPhotoArray _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}