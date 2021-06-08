import { Component, OnInit } from '@angular/core';
import { ProfileService } from '../services/profile.service';
import { GiphyService } from '../services/giphy.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  profiles: Array<any>;

  constructor(private profileService: ProfileService, private giphyService: GiphyService) { }

  ngOnInit() {
    this.profileService.getAll().subscribe(data => {
      this.profiles = data;
      for (const profile of this.profiles) {
        this.giphyService.get(profile.name).subscribe(url => profile.giphyUrl = url);
      }
    });
  }
}
