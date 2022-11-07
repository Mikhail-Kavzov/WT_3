package by.bsuir.lab03.server.service.impl;

import by.bsuir.lab03.server.dao.ApplianceDAO;
import by.bsuir.lab03.server.dao.DAOFactory;
import by.bsuir.lab03.server.entity.info.Info;
import by.bsuir.lab03.server.entity.criteria.Criteria;
import by.bsuir.lab03.server.entity.criteria.SearchCriteria;
import by.bsuir.lab03.server.service.ServerService;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServerServiceImpl implements ServerService {

    private ApplianceDAO applianceDAO;

    public ServerServiceImpl() {
        var factory = DAOFactory.getInstance();
        applianceDAO = factory.getApplianceDAO();
    }

    public List<Info> getAll() {
        return applianceDAO.getAll("src/main/resources/students_db.xml", "Student");
    }

    public boolean addUser(String name, String password, String allowance) throws IOException, SAXException, ParserConfigurationException, TransformerException {
        List<String[]> parameters = new ArrayList<>();
        parameters.add(new String[]{SearchCriteria.Client.name.getEnumName(), name});
        parameters.add(new String[]{SearchCriteria.Client.password.getEnumName(), password});
        parameters.add(new String[]{"allowance", allowance});
        return applianceDAO.add(parameters, "src/main/resources/users_db.xml", "Client");
    }

    public Info getUser(Criteria criteria) {
        List<Info> clientInfoList = applianceDAO.get(criteria, "src/main/resources/users_db.xml", "Client");
        if (!clientInfoList.isEmpty()) {
            return clientInfoList.get(0);
        }
        return null;
    }

    public Info getStudent(Criteria criteria) {
        List<Info> clientInfoList = applianceDAO.get(criteria, "src/main/resources/students_db.xml", "Student");
        if (!clientInfoList.isEmpty()) {
            return clientInfoList.get(0);
        }
        return null;
    }

    public boolean regStudent(String name, String newName, String averageScore) {
        List<String[]> parameters = new ArrayList<>();
        parameters.add(new String[]{SearchCriteria.Student.name.getEnumName(), newName});
        parameters.add(new String[]{SearchCriteria.Student.averageScore.getEnumName(), averageScore});
        return applianceDAO.edit(name, parameters, "src/main/resources/students_db.xml");
    }

    public boolean addStudent(String name, String averageScore) throws ParserConfigurationException, TransformerException, SAXException, IOException {
        List<String[]> parameters = new ArrayList<>();
        parameters.add(new String[]{SearchCriteria.Student.name.getEnumName(), name});
        parameters.add(new String[]{SearchCriteria.Student.averageScore.getEnumName(), averageScore});
        return applianceDAO.add(parameters, "src/main/resources/students_db.xml", "Student");
    }

}