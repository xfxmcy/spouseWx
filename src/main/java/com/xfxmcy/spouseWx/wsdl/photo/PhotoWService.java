package com.xfxmcy.spouseWx.wsdl.photo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.6
 * 2015-06-16T09:03:07.344+08:00
 * Generated source version: 2.7.6
 * 
 */
@WebService(targetNamespace = "http://webservice.spouse.xfxmcy.com/", name = "PhotoWService")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface PhotoWService {

    @WebResult(name = "return", targetNamespace = "http://webservice.spouse.xfxmcy.com/", partName = "return")
    @WebMethod
    public SmPhotoArray queryHisPhotos(
        @WebParam(partName = "arg0", name = "arg0")
        QueryParam arg0
    );

    @WebResult(name = "return", targetNamespace = "http://webservice.spouse.xfxmcy.com/", partName = "return")
    @WebMethod
    public SmPhotoArray queryMyPhotos(
        @WebParam(partName = "arg0", name = "arg0")
        QueryParam arg0
    );
}
