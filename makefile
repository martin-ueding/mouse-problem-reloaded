# Copyright © 2013 Martin Ueding <martin-ueding.de>

all:
	make -C mouse_problem
	make -C particle_box

install:
	make -C mouse_problem install
	make -C particle_box install

.PHONY: clean
clean:
	$(RM) *.class *.jar
	$(RM) *.o *.out
	$(RM) *.orig
	$(RM) *.pyc *.pyo
	$(RM) -r _build
	$(RM) -r build
	$(RM) -r dist
	make -C mouse_problem clean
	make -C particle_box clean
