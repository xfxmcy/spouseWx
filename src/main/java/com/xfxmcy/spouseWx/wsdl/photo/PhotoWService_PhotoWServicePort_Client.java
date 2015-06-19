
package com.xfxmcy.spouseWx.wsdl.photo;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.6
 * 2015-06-16T09:03:07.213+08:00
 * Generated source version: 2.7.6
 * 
 */
public final class PhotoWService_PhotoWServicePort_Client {

    private static final QName SERVICE_NAME = new QName("http://webservice.spouse.xfxmcy.com/", "PhotoWServiceService");

    private PhotoWService_PhotoWServicePort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = PhotoWServiceService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        PhotoWServiceService ss = new PhotoWServiceService(wsdlURL, SERVICE_NAME);
        PhotoWService port = ss.getPhotoWServicePort();  
        
        {
        System.out.println("Invoking queryHisPhotos...");
        com.xfxmcy.spouseWx.wsdl.photo.QueryParam _queryHisPhotos_arg0 = null;
        com.xfxmcy.spouseWx.wsdl.photo.SmPhotoArray _queryHisPhotos__return = port.queryHisPhotos(_queryHisPhotos_arg0);
        System.out.println("queryHisPhotos.result=" + _queryHisPhotos__return);


        }
        {
        System.out.println("Invoking queryMyPhotos...");
        com.xfxmcy.spouseWx.wsdl.photo.QueryParam _queryMyPhotos_arg0 = null;
        com.xfxmcy.spouseWx.wsdl.photo.SmPhotoArray _queryMyPhotos__return = port.queryMyPhotos(_queryMyPhotos_arg0);
        System.out.println("queryMyPhotos.result=" + _queryMyPhotos__return);


        }

        System.exit(0);
    }

}