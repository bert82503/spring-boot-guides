package com.example.reactive.redis;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 咖啡对象。
 * 1.Create a domain class.
 *
 * @author guangyi
 * @since 2022-02-04
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Coffee {

    private String id;
    private String name;
}
