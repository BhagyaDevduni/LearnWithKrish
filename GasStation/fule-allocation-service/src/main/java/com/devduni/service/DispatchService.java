package com.devduni.service;

import com.devduni.model.Dispatch;
import com.devduni.repository.DispatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispatchService {

    @Autowired
    DispatchRepository dispatchRepository;

    public Dispatch save(Dispatch dispatch) {
        return dispatchRepository.save(dispatch);
    }


    public List<Dispatch> getDispatch() {
        List<Dispatch> dispatch= (List<Dispatch>) dispatchRepository.findAll();
        return dispatch;
    }


}
