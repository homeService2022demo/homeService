package com.example.service.mapper.impl;

import com.example.data.dto.OfferDto;
import com.example.data.entity.Offer;
import com.example.service.mapper.GenericMapper;
import lombok.Data;
import org.springframework.stereotype.Service;


/**
 * @author fh.kazemi
 **/


@Data
@Service
public class OfferMapper implements GenericMapper<Offer, OfferDto> {

    private final ExpertMapper expertMapper;

    @Override
    public OfferDto convertToDto(Offer offer) {
        return OfferDto.builder()
                .creationDate(offer.getCreationDate())
                .acceptedDate(offer.getAcceptedDate())
                .rejectedDate(offer.getRejectedDate())
                .offeredPrice(offer.getOfferedPrice())
                .expert(expertMapper.convertToDto(offer.getExpert()))
                .offerStatus(offer.getOfferStatus())
                .offeredWorkDuration(offer.getOfferedWorkDuration())
                .startDate(offer.getStartDate())
                .startTime(offer.getStartTime())
                .doDate(offer.getDoDate())
                .build();
    }

    @Override
    public Offer convertToEntity(OfferDto offerDto) {
        return Offer.builder()
                .creationDate(offerDto.getCreationDate())
                .acceptedDate(offerDto.getAcceptedDate())
                .rejectedDate(offerDto.getRejectedDate())
                .offeredPrice(offerDto.getOfferedPrice())
                .expert(expertMapper.convertToEntity(offerDto.getExpert()))
                .offerStatus(offerDto.getOfferStatus())
                .offeredWorkDuration(offerDto.getOfferedWorkDuration())
                .startDate(offerDto.getStartDate())
                .startTime(offerDto.getStartTime())
                .doDate(offerDto.getDoDate())
                .build();
    }
}
