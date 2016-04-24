package ru.stqa.pft.mantis.tests;

import biz.futureware.mantis.rpc.soap.client.MantisConnectPortType;
import org.testng.annotations.Test;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

/**
 * Created by kosty on 24.04.2016.
 */
public class IssueStatusTest extends TestBase{

    @Test
    public void testIssueStats() throws RemoteException, ServiceException, MalformedURLException {
        System.out.println(app.soap().getIssueStatus(0000001));
    }
}
