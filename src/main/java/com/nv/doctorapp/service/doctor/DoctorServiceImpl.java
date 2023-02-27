package com.nv.doctorapp.service.doctor;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nv.doctorapp.entity.Doctor;
import com.nv.doctorapp.exception.doctor.InvalidDoctorException;
import com.nv.doctorapp.repository.doctor.IDoctorRepository;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	private IDoctorRepository doctorRepository;


	@Override
	public Doctor addDoctor(Doctor doctor) throws Exception {

		if (doctor.getDoctorName().equals("")){
			throw new InvalidDoctorException("Invalid Doctor Name");
		}
		
		if (doctor.getEmail().equals("")){
			throw new InvalidDoctorException("Invalid Email Id");
		}
		
		return doctorRepository.save(doctor);
	}

	@Override
	public List<Doctor> getAllDoctors() {

		return doctorRepository.findAll();
	}

	@Override
	public void removeDoctorById(int doctorId) {

		doctorRepository.deleteById(doctorId);
	}

	@Override
	public Doctor getDoctorById(int doctorId) {

		Doctor savedDoctor = doctorRepository.getReferenceById(doctorId);
		return savedDoctor;
	}

	@Override
	public Doctor updateDoctor(int doctorId) {

		Doctor updatedDoctor = doctorRepository.getReferenceById(doctorId);
		doctorRepository.save(updatedDoctor);
		return updatedDoctor;
		
	}

	@Override
	public List<Doctor> getDoctorByLocation(String location) {
		
		return doctorRepository.getDoctoyByLocation(location);
	}

	@Override
	public List<Doctor> getDoctorBySpeciality(String speciality) {

		return doctorRepository.getDoctorBySpeciality(speciality);
	}
}
