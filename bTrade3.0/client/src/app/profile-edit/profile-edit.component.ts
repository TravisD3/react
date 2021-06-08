import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { ProfileService } from '../services/profile.service';
import { NewProfileService } from '../services/newprofile.service';
import { NgForm } from '@angular/forms';
import { GiphyService } from '../services/giphy.service';
import {FormControl} from '@angular/forms';
import { NewProfile, Homeland } from '../profile-edit/profile-edit.model';

@Component({
  selector: 'app-profile-edit',
  templateUrl: './profile-edit.component.html',
  styleUrls: ['./profile-edit.component.css']
})
export class ProfileEditComponent implements OnInit, OnDestroy {
  profile: any = {};
  homelands: Array<any>;
  countryName: String;
  newProfile: NewProfile = new NewProfile();
  sub: Subscription;
  userId: string;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private profileService:ProfileService,
              private giphyService: GiphyService,
			        private newProfileService:NewProfileService
              ) {
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      // console.log('id', id);
      this.userId = id;

      if (id) {
          this.profileService.get(id).subscribe((profile: any) => {
          if (profile) {
            this.profile = profile;
            this.profile.id = id;
            this.profile.href = "http://localhost:8080/profile-edit" + "/" + id; 
            this.giphyService.get(profile.name).subscribe(url => profile.giphyUrl = url);
          } else {
            console.log(`Profile with id '${id}' not found, returning to list`);
            this.gotoList();
          }
        });
      }
    });
  }

  onInputChanged_country(type_country_symbol: string): void {
    type_country_symbol = type_country_symbol.trim();
    if (type_country_symbol != '') {
      //this.stocks = [];
      if (this.sub) {
        this.sub.unsubscribe();
      }
      this.sub = this.newProfileService.getCountrySymbol(type_country_symbol).subscribe(data => {
        console.log("my data is : " + data);
		this.homelands = data;
      });

    }
  }
  
  setTheCountrySymbol(selected_countrySymbol, selected_mycountry){
	   this.newProfile.country = selected_countrySymbol;
	   this.countryName = selected_mycountry;
	   
  }
  
  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  gotoList() {
    this.router.navigate(['/profile']);
  }

  save(form: NgForm) {
    form['href'] = "http://localhost:8080/profile-edit/" + this.userId;
    this.profileService.save(form).subscribe(result => {
      console.log("result:", result);
      // this.gotoList();
    }, error => console.error(error));
  }

  remove(href) {
    this.profileService.remove(href).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }
}
