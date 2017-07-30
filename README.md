# lejos-support
A repository to add support for LeJOS project

https://sourceforge.net/projects/ev3.lejos.p/files/0.9.1-beta/

## Remote connection

```
ssh -oKexAlgorithms=+diffie-hellman-group1-sha1 root@192.168.1.85
scp -oKexAlgorithms=+diffie-hellman-group1-sha1 ./build/libs/lejos-support-all-0.1.0.jar root@192.168.1.85:/home/root
```

## Remote Execution

### Alternative 1:

```
jrun -cp lejos-support-all-0.1.0.jar examples.HelloWorld
```

### Alternative 2:

```
root@EV3:~# /home/root/lejos/ejre-8-b132-linux-arm-sflt.tar.gz/bin/java -version
java version "1.8.0"
Java(TM) SE Embedded Runtime Environment (build 1.8.0-b132, profile compact3, headless)
Java HotSpot(TM) Embedded Client VM (build 25.0-b70, mixed mode, sharing)

root@EV3:~# /home/root/lejos/ejre-8-b132-linux-arm-sflt.tar.gz/bin/java -jar lejos-support-all-0.1.0.jar 
Hello World
```

Current Activity:

- Add support for NXTCam V5
- http://www.mindsensors.com/pdfs/NXTCam5-User-Guide.pdfls
