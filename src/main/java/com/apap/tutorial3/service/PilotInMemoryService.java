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
			}
		}
		return null;
	}

	@Override
	public void deletePilot(String id) {
		for (PilotModel pilotModel : archivePilot) {
			if (pilotModel.getId().equalsIgnoreCase(id)) {
				archivePilot.remove(pilotModel);
			} 
		}
	}

	@Override
	public PilotModel getPilotById(String id) {
		for (PilotModel pilotModel : archivePilot) {
			if (pilotModel.getId().equalsIgnoreCase(id)) {
				return pilotModel;
			}
		}
		return null;
	}
}
