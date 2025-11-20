package com.efub.livin.house.dto.response;

import com.efub.livin.house.domain.House;
import com.efub.livin.house.domain.HouseType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class HouseResponse {

    private Long houseId;
    private String buildingName;
    private String address;
    private Boolean parking;
    private HouseType type;
    private String options;
    private String x; // 경도
    private String y; // 위도
    private String imageUrl;
    private boolean isBookmarked;   // 북마크 여부

    public static HouseResponse from(House house, boolean isBookmarked){
        HouseResponse response = new HouseResponse();
        response.houseId = house.getHouseId();
        response.buildingName = house.getBuildingName();
        response.address = house.getAddress();
        response.type = house.getType();
        response.parking = house.getParking();
        response.options = house.getOptions();
        response.x = house.getLon(); // 경도
        response.y = house.getLat(); // 위도
        response.imageUrl = house.getImageUrl();
        response.isBookmarked = isBookmarked;
        return response;
    }

    // 북마크 정보 필요 없는 경우
    public static HouseResponse from(House house) {
        return from(house, false);
    }
}
