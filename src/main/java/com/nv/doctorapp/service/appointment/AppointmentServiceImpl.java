package com.nv.doctorapp.service.appointment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nv.doctorapp.entity.Appointment;
import com.nv.doctorapp.repository.appointment.AppointmentRepository;
import com.nv.doctorapp.repository.doctor.IDoctorRepository;


@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	AppointmentRepository appointmentRepository;
	
	@Autowired 
	IDoctorRepository idoctorRepository;
	
//	@Autowired 
//	CustomAppointmentRepository customAppointmentRepository;

	@Override
	public List<Appointment> getAllAppointments() {
		// TODO Auto-generated method stub
		return appointmentRepository.findAll();
	}

	@Override
	public Appointment getAppointmentById(int appointmentId) {
		// TODO Auto-generated method stub
		return appointmentRepository.getReferenceById(appointmentId);
	}

	@Override
	public Appointment addAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		return appointmentRepository.save(appointment);
	}

	@Override
	public void removeAppointmentById(int appointmentId) {
		// TODO Auto-generated method stub
		 appointmentRepository.deleteById(appointmentId);
	}

	@Override
	public List<Appointment> getAppointmentByStatus(String status) {
		// TODO Auto-generated method stub
		return appointmentRepository.getAppointmentByStatus(status);
	}

	@Override
	public List<Appointment> getAppointmentByDate(String date) {
		// TODO Auto-generated method stub
		return appointmentRepository.getAppointmentByDate(date);
	}

	@Override
	public Appointment updateAppointmentById(int appointmentId) {
		// TODO Auto-generated method stub
		return null;
	}


	

	
	
	
	
	
	

	
	
}
