package com.yiwobao.pojo;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Component
public class Dog {
    private String dogName;
    private Double dogWeight;


}
