################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../Hello.cpp 

OBJS += \
./Hello.o 

CPP_DEPS += \
./Hello.d 


# Each subdirectory must supply rules for building sources it contributes
%.o: ../%.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -I"../$CYGWIN_HOME\lib\gcc\i686-pc-cygwin\4.5.x\include\c++" -I"../$CYGWIN_HOME\lib\gcc\i686-pc-cygwin\4.5.x\include\c++\i686-pc-cygwin" -I"../$CYGWIN_HOME\lib\gcc\i686-pc-cygwin\4.5.x\include\c++\backward" -I"../$CYGWIN_HOME\lib\gcc\i686-pc-cygwin\4.5.x\include" -I"../$CYGWIN_HOME\lib\gcc\i686-pc-cygwin\4.5.x\include-fixed" -I"../$CYGWIN_HOME\usr\include" -I"../$CYGWIN_HOME\usr\include\w32api" -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


