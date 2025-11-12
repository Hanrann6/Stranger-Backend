package com.efub.livin.house.domain;

import com.efub.livin.house.dto.request.HouseCreateRequest;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "house")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long houseId;

    private String buildingName;
    private String address;
    private String image;
    private String phone; // 대표 번호
    private float lat; // 위도
    private float lon; // 경도
    private String place_url; // 상세 페이지 URL
    private String docId; // 지도 자체 장소 id
    private Integer floor;
    private Boolean parking;
    private String options;
    // 가격대

    @Enumerated(EnumType.STRING)
    private HouseType type; // 자취방 PRIVATE, 하숙 BOARDING

    // 리뷰 관련
    private float rate;

    // 리뷰 관계 코드

    // Document dto -> House 엔티티로 변환
    public static House from(Document dto, HouseType type){
        House house = new House();
        house.buildingName = dto.getPlace_name();
        house.address = dto.getAddress_name();
        house.phone = dto.getPhone();
        house.lat = Float.parseFloat(dto.getX());
        house.lon = Float.parseFloat(dto.getY());
        house.docId = dto.getId();
        house.type = type;
        return house;
    }

    //
    public static House create(HouseCreateRequest request){
        House house = new House();
        house.type = request.getType();
        house.buildingName = request.getBuildingName();
        house.address = request.getAddress();
        house.options = request.getOptions();
        house.parking = request.getParking();
        // 위도, 경도 추가 로직
        return house;
    }

}
