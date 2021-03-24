build:
	docker build . -t qatest

up:
	docker run -it qatest

bash:
	docker run -it qatest /bin/bash
