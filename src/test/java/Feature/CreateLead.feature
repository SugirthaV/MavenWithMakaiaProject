Feature: LeafTaps
Background:
Given Open Browser
And Launch the url
And Maximize Browser
And Set Outtime
And Username as DemoSalesManager 
And password as crmsfa
And Click on Login
And Click CRMLink

@smoke
Scenario Outline: Login should be positive
Given Click leads
And Click CreateLead
And Enter CompanyName <cmpyName>
And Enter FirstName <fName>
And Enter LastName <LName>
When Click on createLead Button
Then CreateLead Complete

Examples:
|cmpyName|fName|LName|
|CTS|Sugirtha|V|
|Wipro|Dhana|V|

@sanity
Scenario Outline: Login should be negative
Given Click leads
And Click CreateLead
And Enter CompanyName <cmpyName>
And Enter FirstName <fName>
And Enter LastName <LName>
When Click on createLead Button
Then CreateLead Complete

Examples:
|cmpyName|fName|LName|
|CTS|Sugirtha|V|
|Wipro|Dhana|V|