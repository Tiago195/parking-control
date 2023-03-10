package com.api.parkingcontrol.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;

import jakarta.transaction.Transactional;

// import javax.transaction.Transactional;

@Service
public class ParkingSpotService {

  final ParkingSpotRepository parkingSpotRepository;

  public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
    this.parkingSpotRepository = parkingSpotRepository;
  }

  @Transactional
  public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
    this.parkingSpotRepository.save(parkingSpotModel);
    return parkingSpotModel;
  }

  public Page<ParkingSpotModel> findAll(Pageable pageable) {
    return this.parkingSpotRepository.findAll(pageable);
  }

  public Optional<ParkingSpotModel> findById(UUID id) {
    return this.parkingSpotRepository.findById(id);
  }

  @Transactional
  public void delete(ParkingSpotModel parkingSpotModel) {
    this.parkingSpotRepository.delete(parkingSpotModel);
  }

  public boolean existsByLicensePlateCar(String licensePlateCar) {
    return this.parkingSpotRepository.existsByLicensePlateCar(licensePlateCar);
  }

  public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
    return this.parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
  }

  public boolean existsByApartmentAndBlock(String apartment, String block) {
    return this.parkingSpotRepository.existsByApartmentAndBlock(apartment, block);
  }

}
