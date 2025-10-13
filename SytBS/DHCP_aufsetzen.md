# DHCP Server aufsetzen auf der VM

   47  history
   48  systemctl status sshd
   49  cd .ssh/
   50  la
   51  ls -la
   52  exit
   
---
   
## change in interfaces dhcp to static

   53  vim /etc/network/interfaces
   
**from:**
	iface enq0s3 inet dhcp
**to:**
	iface enq0s3 inet static
		address 10.0.5.--/24
		gateway 10.0.5.1
   
   54  ip a
   55  systemctl restart networking.service 
   56  ip a
   
---

## installing dhcp-server

   57  apt search dhcp-server
   58  apt install kea-dhcp4-server
   
---
   
## editing the .conf file so we can use it (important!!!)

   59  cd /etc/kea/
   60  ls -la
   
* **make a copy of the current file where we can do what we want**

   61  cp kea-dhcp4.conf kea-dhcp4_orig.conf 
   62  ls -la
   63  vim kea-dhcp4.conf 
   
* **this grep command removes all comments in the .conf file and more but i am not sure what**
   
   64  grep -v "//" /etc/kea/kea-dhcp4.conf | grep -v -e "^$" > /etc/kea/kea-dhcp4.conf2
   
* **i am going to upload the .conf file so you see what you have to do and please keep in mind if you have a typingmistake with 'systemctl status kea-dhcp4-server.service' you can see at what line you wrote something that the programm doesn't understand**
   
   65  vim kea-dhcp4.conf2
   66  vim kea-dhcp4.conf2
   67  cat kea-dhcp4.conf2 > kea-dhcp4.conf
   68  cat kea-dhcp4.conf
   69  systemctl restart kea-dhcp4-server.service 
   70  systemctl status kea-dhcp4-server.service 
   71  exit


