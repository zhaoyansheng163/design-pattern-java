package com.example.design.ChainofResponsibility;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeaveRequest {
    /**天数*/
    private int leaveDays;

    /**姓名*/
    private String name;
}
