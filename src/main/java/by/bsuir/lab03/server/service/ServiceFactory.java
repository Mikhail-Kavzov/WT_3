package by.bsuir.lab03.server.service;

import by.bsuir.lab03.server.service.impl.ServerServiceImpl;

public final class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private final ServerService applianceService = new ServerServiceImpl();

    private ServiceFactory() {
    }

    public ServerService getApplianceService() {

        return applianceService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

}
