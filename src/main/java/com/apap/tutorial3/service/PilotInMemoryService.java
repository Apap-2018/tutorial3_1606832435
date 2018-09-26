package com.apap.tutorial3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.apap.tutorial3.model.PilotModel;

@Service
public class PilotInMemoryService implements PilotService{
	
	private List<PilotModel> archivePilot;

	public PilotInMemoryService() {
		archivePilot = new ArrayList<>();
	}

	@Override
	public void addPilot(PilotModel pilot) {
		archivePilot.add(pilot);
	}

	@Override
	public List<PilotModel> getPilotList() {
		return archivePilot;
	}

	@Override
	public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
		for (PilotModel pilotModel : archivePilot) {
			if (pilotModel.getLicenseNumber().equalsIgnoreCase(licenseNumber)) {
				return pilotModel;
			} else {
				return null;
			}
		}
		return null;
	}

	@Override
	public void deletePilot(String licenseNumber) {
		for (PilotModel pilotModel : archivePilot) {
			if (pilotModel.getLicenseNumber().equalsIgnoreCase(licenseNumber)) {
				archivePilot.remove(pilotModel);
			} 
		}
	}
}
