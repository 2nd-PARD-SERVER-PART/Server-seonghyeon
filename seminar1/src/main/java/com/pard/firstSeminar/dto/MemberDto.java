// shift + f6 => 전체 변수 바꾸기
package com.pard.firstSeminar.dto;

public class MemberDto {
    private String myName;
    private String teamName;

    public MemberDto(String myName, String teamName){
        this.myName = myName;
        this.teamName = teamName;
    }

    @Override
    public String toString() {
        return "MemberDto{" +
                "myName='" + myName + '\'' +
                ", teamName='" + teamName + '\'' +
                '}';
    }

    public String getMyName() {
        return myName;
    }

    public String getTeamName() {
        return teamName;
    }
}
