package com.efub.livin.house.domain;

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

    @Enumerated(EnumType.STRING)
    private HouseType type; // 자취방 PRIVATE, 하숙 BOARDING

    // 리뷰 관련
    private float rate;
    private int floor;
    //private enum option;
    private boolean parking;

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

}
