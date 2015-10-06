package ru.codeunited;

public class LaunchControlServiceImpl implements LaunchControlService {

    public TalendJobServiceDescriptor echo() {
        return new TalendJobServiceDescriptor("MyJobOSGi", "1.0.2");
    }

}