package com.example.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.login.modul.Msg;

public interface MsgRepository  extends JpaRepository<Msg, Long>  {

}
