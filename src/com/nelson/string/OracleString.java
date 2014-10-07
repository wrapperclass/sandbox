package com.nelson.string;

public class OracleString {

    public static final String GET_AREAS = "SELECT " +
            "MOV.ORG_ID AREA_ORG_ID, " +
            "MOV.ORG_NAME AREA_NAME, " +
            "MAV.ASSGN_PERSON_NAME ASSGN_PERSON_NAME, " +
            "MEMBER_COUNT, " +
            "(SELECT COUNT (*) FROM MDMR_ORG_VW WHERE ORG_TYPE_ID = 10 AND AREA_ORG_ID = MOV.ORG_ID) AS TEMPLES " +
            "FROM MDMR_ORG_VW MOV " +
            "LEFT JOIN MDMR_ASSIGNMENT_VW MAV ON MOV.ORG_ID = MAV.ORG_ID " +
            "JOIN (SELECT /*+ USE_MERGE(A1,M1) */ SUM (MEMBER_COUNT) MEMBER_COUNT, AREA_ORG_ID " +
            "FROM MEMBER_ACCUMULATE_FACT_VW A1, MDMR_ORG_VW M1 " +
            "WHERE STAKE_ORG_ID = M1.ORG_ID " +
            "AND m1.org_type_id = 5" +
            "AND DATE_KEY IN (SELECT DISTINCT MAX (DATE_KEY) FROM MEMBER_ACCUMULATE_FACT_VW) GROUP BY AREA_ORG_ID) CNT " +
            "ON CNT.AREA_ORG_ID = MOV.ORG_ID " +
            "WHERE MOV.ORG_TYPE_ID = 1 " +                     // 1=area
            "AND MAV.POSITION_TYPE_ID IN (6, 30, 31) " +     // 6=Area President, 30=Presidency of the Seventy President, 31=First Quorum of the Seventy Member
            "AND MAV.ASSIGNMENT_STATUS = 'Active' " +
            "ORDER BY MOV.ORG_NAME ASC";

    public static void main(String args[]) {

        System.out.println("Select Statement: " + GET_AREAS);
    }

}
