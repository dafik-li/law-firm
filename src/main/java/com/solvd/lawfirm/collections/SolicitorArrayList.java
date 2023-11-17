package com.solvd.lawfirm.collections;

import com.solvd.lawfirm.controller.Creator;
import com.solvd.lawfirm.entity.persons.SolicitorPerson;
import java.util.*;

public class SolicitorArrayList {
    private Creator creator;

    public SolicitorArrayList() {
        this.creator = new Creator();
    }
    private List<SolicitorPerson> createSolicitorPersonList() {
        List<SolicitorPerson> solicitorPersonList = new ArrayList<>();
        solicitorPersonList.add(creator.createSolicitorPerson('m', "marlon", "brando", 100, 1));
        solicitorPersonList.add(creator.createSolicitorPerson('m', "al", "pacino", 80, 2));
        solicitorPersonList.add(creator.createSolicitorPerson('m', "jack", "nicholson", 90, 3));
        return solicitorPersonList;
    }
    public SolicitorPerson findSolicitor(int level) throws Exception {
        List<SolicitorPerson> solicitorList = createSolicitorPersonList();
        for (SolicitorPerson solicitor : solicitorList) {
            if (solicitor.getSolicitorLevel() == level) {
                return solicitor;
            }
        }
        throw new Exception("Cannot find solicitor");
    }
}
