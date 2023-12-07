package com.solvd.lawfirm.collections;

import com.solvd.lawfirm.controller.Creator;
import com.solvd.lawfirm.controller.Generator;
import com.solvd.lawfirm.entity.persons.SolicitorPerson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.ArrayList;
import java.util.List;

public class SolicitorArrayList {
    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }
    private final static Logger LOGGER = (Logger) LogManager.getLogger(Generator.class);
    private Creator creator;

    public SolicitorArrayList() {
        this.creator = new Creator();
    }
    private List<SolicitorPerson> createSolicitorPersonList() {
        List<SolicitorPerson> solicitorPersonList = new ArrayList<>();
        solicitorPersonList.add(creator.createSolicitorPerson
                ('m', "marlon", "brando", 100, 1));
        solicitorPersonList.add(creator.createSolicitorPerson
                ('m', "al", "pacino", 80, 2));
        solicitorPersonList.add(creator.createSolicitorPerson
                ('m', "jack", "nicholson", 90, 3));
        return solicitorPersonList;
    }

    public SolicitorPerson findSolicitor(int level) {
        List<SolicitorPerson> solicitorList = createSolicitorPersonList();
        long countSolicitors = createSolicitorPersonList().stream()
                .filter(solicitor -> solicitor.getLevel(solicitor) == level)
                .count();
        LOGGER.info("Count of solicitors satisfying level - " + countSolicitors);
        return solicitorList.stream()
                .filter(solicitor -> solicitor.getLevel(solicitor) == level)
                .findFirst().orElse(null);
    }
    /*public SolicitorPerson findSolicitor(int level) throws Exception {
        List<SolicitorPerson> solicitorList = createSolicitorPersonList();
        for (SolicitorPerson solicitor : solicitorList) {
            if (solicitor.getLevel(solicitor) == level) {
                return solicitor;
            }
        }
        throw new Exception("Cannot find solicitor");
    }
     */
}
