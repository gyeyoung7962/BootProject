package com.example.springprj.service;

import com.example.springprj.domain.Doctor;
import com.example.springprj.repository.DoctorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Service
public class DoctorServiceImpl implements DoctorService {
    private final DoctorMapper doctorMapper;

    public DoctorServiceImpl(DoctorMapper doctorMapper){
        this.doctorMapper = doctorMapper;
    }

    @Override
    public void insertDoctor(Doctor doctor, MultipartFile file) throws Exception {
        //프로젝트 담을 경로
        String projectPath = System.getProperty("user.dir")+ "/src/main/resources/static/upload";

//        UUID uuid = UUID.randomUUID();

        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

        File saveFile = new File(projectPath, fileName);

        file.transferTo(saveFile);

        doctor.setFile_name(fileName);
        doctor.setFile_path("/upload/" +fileName);

        doctorMapper.insertDoctor(doctor);

    }

    @Override
    public void insertDoctor(Doctor doctor){

        doctorMapper.insertDoctor(doctor);
    }

    @Override
    public List<Doctor> doctorList() {

        return doctorMapper.doctorList();
    }

    @Override
    public List<Doctor> doctorList(String hospital_code) {

        return doctorMapper.doctorList(hospital_code);
    }


    @Override
    public Doctor login(String doctor_code, String doctor_pw) {

        return doctorMapper.login(doctor_code, doctor_pw);
    }


    @Override
    public int id_chk(String doctor_code) {

        return doctorMapper.id_chk(doctor_code);
    }

    @Override
    public Doctor doctorInfo(int doctor_no) {

        return doctorMapper.doctorInfo(doctor_no);
    }


    @Override
    public void doctorDelete(int doctor_no, Doctor doctor) {



        String projectPath = System.getProperty("user.dir")+"/src/main/resources/static/upload"; //프로젝트 폴더경로

        System.out.println("projectPath = " + projectPath);

        File f = new File(projectPath, doctor.getFile_name());  //프로젝트경로와 파일이름으로 경로생성

        System.out.println("기존파일체크 f:"+ f.exists());

        if(f.exists()){   //경로에 파일있으면 삭제
            f.delete();
        }

        doctorMapper.doctorDelete(doctor_no);
    }

    @Override
    public void doctorDelete(int doctor_no) {


        doctorMapper.doctorDelete(doctor_no);
    }


    @Override
    public void doctorModify(Doctor doctor, MultipartFile file) throws Exception {



        String projectPath = System.getProperty("user.dir")+"/src/main/resources/static/upload"; //프로젝트 폴더경로

        System.out.println("projectPath = " + projectPath);

        File f = new File(projectPath, doctor.getFile_name());  //프로젝트경로와 파일이름으로 경로생성

        System.out.println("기존파일체크 f:"+ f.exists());

        if(f.exists()){   //경로에 파일있으면 삭제
            f.delete();
        }

        String fileName =  System.currentTimeMillis() + "_" + file.getOriginalFilename(); //중복안되게 파일이름생성

        File saveFile = new File(projectPath, fileName); // 저장할 파일  프로젝트경로와 파일이름으로 경로생성

        System.out.println("save:"+saveFile);

        file.transferTo(saveFile);  //받아온 이미지파일을 경로에 저장

        doctor.setFile_name(fileName); //디비에 값저장
        doctor.setFile_path("/upload/"+fileName);

        doctorMapper.doctorModify(doctor);
//        doctorMapper.doctorModify(doctor, file);
    }

    @Override
    public void doctorModify(Doctor doctor) throws Exception {


        doctorMapper.doctorModify(doctor);

    }
}
