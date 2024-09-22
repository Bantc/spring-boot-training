package com.example.rest;

// Record. Do not need explicit constructor, getter or setter methods as well as toString(), hashCode() etc since it's autogenerated
public record OrderRecord(String customerName, String productName, int quantity) {}
